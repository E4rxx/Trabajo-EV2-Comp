package prog.trbe2.jsonstuff

import kotlinx.serialization.json.Json
import prog.trbe2.DTO.Personal
import java.io.File

class JSONReadWrite(private val archivoJSON: File) {
    //la funcion principal de esta clase
    //si sale bien devuelve el archivo
    fun mainReadJSON(archivoJson: File) : File {
        if (existeJSON(archivoJSON) && legibleJSON(archivoJSON)) {
            return archivoJSON
        } else {
            throw IllegalArgumentException("⚠️ Error en la verificación del archivo JSON")
        }
    }

    //esto comprueba si esta o no
    fun existeJSON(archivoJSON: File): Boolean {
        var resultFind: Boolean = false
        print("🔄 Buscando el archivo JSON ")
        when {
            archivoJSON.exists() -> {
                println("✅ Archivo encontrado!")
                resultFind = true
            }
            !archivoJSON.exists() -> {
                throw IllegalArgumentException("⚠️ Archivo no encontrado!")
                resultFind = false
            }
        }
        return resultFind
    }

    //esto comprueba si es legible o no
    fun legibleJSON(archivoJSON: File): Boolean {
        var resultFind: Boolean = false
        print("🔄 Comprobando el archivo JSON ")
        when {
            archivoJSON.canRead() -> {
                println("✅ Archivo listo para usar!")
                println()
                resultFind = true
            }
            !archivoJSON.canRead() -> {
                throw IllegalArgumentException("⚠️ Archivo no legible, bórralo y añade uno que sí lo sea")
                resultFind = false
            }
        }
        return resultFind
    }

    fun analizadorJSON(archivoJSON: File): List<Personal> {
        val jsonString = archivoJSON.readText()
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromString(jsonString)
    }
}