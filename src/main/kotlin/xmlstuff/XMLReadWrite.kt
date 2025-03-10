package prog.trbe2.xmlstuff

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import prog.trbe2.DTO.Personal
import prog.trbe2.DTO.PersonalXML
import java.io.File


class XMLReadWrite(private val archivoXML: File) {
    //la funcion principal de esta clase
    //si sale bien devuelve el archivo
    fun mainReadXML(archivoXML: File) : File {
        if (existeXML(archivoXML) && legibleXML(archivoXML)) {
            return archivoXML
        } else {
            throw IllegalArgumentException("⚠️ Error en la verificación del archivo XML")
        }
    }

    //esto comprueba si esta o no
    private fun existeXML(archivoXML: File): Boolean {
        var resultFind: Boolean = false
        print("🔄 Buscando el archivo XML ")
        when {
            archivoXML.exists() -> {
                println("✅ Archivo encontrado!")
                resultFind = true
            }
            !archivoXML.exists() -> {
                throw IllegalArgumentException("⚠️ Archivo no encontrado!")
                resultFind = false
            }
        }
        return resultFind
    }

    //esto comprueba si es legible o no
    private fun legibleXML(archivoXML: File): Boolean {
        var resultFind: Boolean = false
        print("🔄 Comprobando el archivo XML ")
        when {
            archivoXML.canRead() -> {
                println("✅ Archivo listo para usar!")
                println()
                resultFind = true
            }
            !archivoXML.canRead() -> {
                throw IllegalArgumentException("⚠️ Archivo no legible, bórralo y añade uno que sí lo sea")
                resultFind = false
            }
        }
        return resultFind
    }

    //analizar el archivo XML
    fun analizadorXML(archivoXML: File): List<PersonalXML> {
        val xmlMapper = XmlMapper()
        val personales = xmlMapper.readValue(archivoXML, Array<PersonalXML>::class.java)
        return personales.toList()
    }
}
