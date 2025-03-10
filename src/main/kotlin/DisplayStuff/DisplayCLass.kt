package prog.trbe2.DisplayStuff

import prog.trbe2.csvstuff.CSVReadWrite
import prog.trbe2.csvstuff.FusionReadWrite
import prog.trbe2.jsonstuff.JSONReadWrite
import prog.trbe2.xmlstuff.XMLReadWrite
import prog.trbe2.filestuff.BuscadorArchivos

class DisplayCLass {
    val fileFinder = BuscadorArchivos()
    val archivoCSV = fileFinder.buscarCSV()
    val archivoJSON = fileFinder.buscarJSON()
    val archivoXML = fileFinder.buscarXML()

    val csvReadWrite = CSVReadWrite(archivoCSV)
    val jsonReadWrite = JSONReadWrite(archivoJSON)
    val xmlReadWrite = XMLReadWrite(archivoXML)

    val personalListCSV = csvReadWrite.analizadorCSV(archivoCSV)
    val personalListJSON = jsonReadWrite.analizadorJSON(archivoJSON)
    val personalListXML = xmlReadWrite.analizadorXML(archivoXML)

    fun displayCSV() {
        csvReadWrite.mainReadCSV(archivoCSV)
        println("🖨️ Imprimiendo el archivo CSV")
        personalListCSV.forEach { personal ->
            println("Personal(id=${personal.id}, " +
                    "nombre=${personal.nombre ?: "N/A"}, " +
                    "apellidos=${personal.apellidos}, " +
                    "fechaNacimiento=${personal.fechaNacimiento ?: "N/A"}, " +
                    "fechaIncorporacion=${personal.fechaIncorporacion ?: "N/A"}, " +
                    "salario=${personal.salario ?: "N/A"}, " +
                    "pais=${personal.pais}, " +
                    "rol=${personal.rol}, " +
                    "especialidad=${personal.especialidad ?: "N/A"}, " +
                    "posicion=${personal.posicion ?: "N/A"}, " +
                    "dorsal=${personal.dorsal ?: "N/A"}, " +
                    "altura=${personal.altura ?: "N/A"}, " +
                    "peso=${personal.peso ?: "N/A"}, " +
                    "goles=${personal.goles ?: "N/A"}, " +
                    "partidosJugados=${personal.partidosJugados ?: "N/A"})")
        }
    }

    fun displayJSON() {
        jsonReadWrite.mainReadJSON(archivoJSON)
        println("🖨️ Imprimiendo el archivo JSON")
        personalListJSON.forEach { personal ->
            println("Personal(id=${personal.id}, " +
                    "nombre=${personal.nombre ?: "N/A"}, " +
                    "apellidos=${personal.apellidos}, " +
                    "fechaNacimiento=${personal.fechaNacimiento ?: "N/A"}, " +
                    "fechaIncorporacion=${personal.fechaIncorporacion ?: "N/A"}, " +
                    "salario=${personal.salario ?: "N/A"}, " +
                    "pais=${personal.pais}, " +
                    "rol=${personal.rol}, " +
                    "especialidad=${personal.especialidad ?: "N/A"}, " +
                    "posicion=${personal.posicion ?: "N/A"}, " +
                    "dorsal=${personal.dorsal ?: "N/A"}, " +
                    "altura=${personal.altura ?: "N/A"}, " +
                    "peso=${personal.peso ?: "N/A"}, " +
                    "goles=${personal.goles ?: "N/A"}, " +
                    "partidosJugados=${personal.partidosJugados ?: "N/A"})")
        }
    }

    fun displayXML() {
        xmlReadWrite.mainReadXML(archivoXML)
        println("🖨️ Impriminedo el archivo XML")
        personalListXML.forEach { personal ->
            println("Personal(id=${personal.id}, " +
                    "nombre=${personal.nombre ?: "N/A"}, " +
                    "apellidos=${personal.apellidos}, " +
                    "fechaNacimiento=${personal.fechaNacimiento ?: "N/A"}, " +
                    "fechaIncorporacion=${personal.fechaIncorporacion ?: "N/A"}, " +
                    "salario=${personal.salario ?: "N/A"}, " +
                    "pais=${personal.pais}, " +
                    "rol=${personal.rol}, " +
                    "especialidad=${personal.especialidad ?: "N/A"}, " +
                    "posicion=${personal.posicion ?: "N/A"}, " +
                    "dorsal=${personal.dorsal ?: "N/A"}, " +
                    "altura=${personal.altura ?: "N/A"}, " +
                    "peso=${personal.peso ?: "N/A"}, " +
                    "goles=${personal.goles ?: "N/A"}, " +
                    "partidosJugados=${personal.partidosJugados ?: "N/A"})")
        }
    }

    fun displayFusion() {
        val archivoFusion = fileFinder.buscarFusion()
        val fusionReadWrite = FusionReadWrite()
        fusionReadWrite.mainReadNewFusion(archivoFusion)
        val personalListFusion = csvReadWrite.analizadorCSV(archivoFusion)
        println("🖨️ Imprimiendo el archivo fusionado")
        personalListFusion.forEach { personal ->
            println("Personal(id=${personal.id}, " +
                    "nombre=${personal.nombre ?: "N/A"}, " +
                    "apellidos=${personal.apellidos}, " +
                    "fechaNacimiento=${personal.fechaNacimiento ?: "N/A"}, " +
                    "fechaIncorporacion=${personal.fechaIncorporacion ?: "N/A"}, " +
                    "salario=${personal.salario ?: "N/A"}, " +
                    "pais=${personal.pais}, " +
                    "rol=${personal.rol}, " +
                    "especialidad=${personal.especialidad ?: "N/A"}, " +
                    "posicion=${personal.posicion ?: "N/A"}, " +
                    "dorsal=${personal.dorsal ?: "N/A"}, " +
                    "altura=${personal.altura ?: "N/A"}, " +
                    "peso=${personal.peso ?: "N/A"}, " +
                    "goles=${personal.goles ?: "N/A"}, " +
                    "partidosJugados=${personal.partidosJugados ?: "N/A"})")
        }
    }
}