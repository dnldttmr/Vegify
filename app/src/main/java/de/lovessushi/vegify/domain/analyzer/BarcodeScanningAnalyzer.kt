package de.lovessushi.vegify.domain.analyzer

import androidx.annotation.OptIn
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode.FORMAT_EAN_13
import com.google.mlkit.vision.barcode.common.Barcode.FORMAT_EAN_8
import com.google.mlkit.vision.common.InputImage

class BarcodeScanningAnalyzer(
    private val onBarcodeDetected: (barcodeRawValue: String) -> Unit
) : ImageAnalysis.Analyzer {

    private val options =
        BarcodeScannerOptions
            .Builder()
            .setBarcodeFormats(FORMAT_EAN_8, FORMAT_EAN_13)
            .build()
    private val scanner = BarcodeScanning.getClient(options)

    @OptIn(ExperimentalGetImage::class)
    override fun analyze(imageProxy: ImageProxy) {
        imageProxy.image?.let {
            val imageValue = InputImage.fromMediaImage(it, imageProxy.imageInfo.rotationDegrees)
            scanner.process(imageValue)
                .addOnSuccessListener { barcodes ->
                    barcodes.getOrNull(0)?.rawValue?.let { barcodeRawValue ->
                        onBarcodeDetected(barcodeRawValue)
                    }
                }
                .addOnFailureListener { failure -> failure.printStackTrace() }
                .addOnCompleteListener { imageProxy.close() }
        }
    }
}