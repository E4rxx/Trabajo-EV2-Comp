package prog.trbe2.filestuff

import prog.trbe2.csvstuff.CSVReadWrite
import prog.trbe2.jsonstuff.JSONReadWrite
import prog.trbe2.xmlstuff.XMLReadWrite
import prog.trbe2.csvstuff.FusionReadWrite
import prog.trbe2.DTO.Personal
import java.io.File
import java.io.FileWriter
import java.io.BufferedWriter

class FileFusioner {
    val fileFinder = BuscadorArchivos()
    val archivoXML = fileFinder.buscarXML()
    val archivoCSV = fileFinder.buscarCSV()
    val archivoJSON = fileFinder.buscarJSON()
    val archivoFusion = fileFinder.buscarFusion()
    val xmlReadWrite = XMLReadWrite(archivoXML)
    val csvReadWrite = CSVReadWrite(archivoCSV)
    val jsonReadWrite = JSONReadWrite(archivoJSON)
    val fusionReadWrite = FusionReadWrite()

    fun mainFileFusioner() : File {
        val fusionFile = fusionReadWrite.mainReadFusion(archivoFusion)
        val csvFile = csvReadWrite.mainReadCSV(archivoCSV)
        val jsonFile = jsonReadWrite.mainReadJSON(archivoJSON)
        val xmlFile = xmlReadWrite.mainReadXML(archivoXML)

        if (archivoFusion != null && archivoCSV != null && archivoJSON != null && archivoXML != null) {
            val personalList = recopilarDatos(csvFile, jsonFile, xmlFile)
            escribirFusion(personalList, fusionFile)
            return archivoFusion
        } else {
            throw IllegalArgumentException("⚠️ Error en la verificación de los archivos")
        }
    }

    private fun recopilarDatos(csvFile: File, jsonFile: File, xmlFile: File): List<Personal> {
        val personalList = mutableListOf<Personal>()
        personalList.addAll(csvReadWrite.analizadorCSV(archivoCSV))
        personalList.addAll(jsonReadWrite.analizadorJSON(archivoJSON))
        var currentMaxId = personalList.maxOfOrNull { it.id } ?: 0
        val xmlData = xmlReadWrite.analizadorXML(archivoXML).map { personalXML ->
            currentMaxId += 1
            Personal(
                id = currentMaxId, // Assign the next sequential ID
                nombre = personalXML.nombre,
                apellidos = personalXML.apellidos,
                fechaNacimiento = personalXML.fechaNacimiento,
                fechaIncorporacion = personalXML.fechaIncorporacion,
                salario = personalXML.salario,
                pais = personalXML.pais,
                rol = personalXML.rol,
                especialidad = personalXML.especialidad,
                posicion = personalXML.posicion,
                dorsal = personalXML.dorsal,
                altura = personalXML.altura,
                peso = personalXML.peso,
                goles = personalXML.goles,
                partidosJugados = personalXML.partidosJugados
            )
        }
        personalList.addAll(xmlData)
        return personalList
    }

    private fun escribirFusion(personalList: List<Personal>, archivoFusion: File) {
        BufferedWriter(FileWriter(archivoFusion)).use { writer ->
            writer.write("id,nombre,apellidos,fechaNacimiento,fechaIncorporacion,salario,pais,rol,especialidad,posicion,dorsal,altura,peso,goles,partidosJugados\n")
            for (personal in personalList) {
                writer.write("${personal.id},${personal.nombre},${personal.apellidos},${personal.fechaNacimiento},${personal.fechaIncorporacion},${personal.salario},${personal.pais},${personal.rol},${personal.especialidad ?: ""},${personal.posicion ?: ""},${personal.dorsal ?: ""},${personal.altura ?: ""},${personal.peso ?: ""},${personal.goles ?: ""},${personal.partidosJugados ?: ""}\n")
            }
        }
    }
}
