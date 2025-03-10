package prog.trbe2.filestuff

import java.io.File

class BuscadorArchivos {
    private val currentDir = System.getProperty("user.dir")

    fun buscarXML(): File {
        val archivoXML = File(currentDir, "personal.xml")
        return archivoXML
    }
    fun buscarCSV(): File {
        val archivoCSV = File(currentDir, "personal.csv")
        return archivoCSV
    }
    fun buscarJSON(): File {
        val archivoJSON = File(currentDir, "personal.json")
        return archivoJSON
    }
    fun buscarFusion(): File {
        val fileFusion = File(currentDir, "fileFusion.csv")
        return fileFusion
    }
}