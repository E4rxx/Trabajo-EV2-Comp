package prog.trbe2.csvstuff

import prog.trbe2.DTO.Personal
import java.io.File

class CSVReadWrite(val archivoCSV: File) {
    //la funcion principal de esta clase
    //si sale bien devuelve el archivo
    fun mainReadCSV(archivoCSV: File): File {
        if (existeCSV(archivoCSV) && legibleCSV(archivoCSV)) {
            return archivoCSV
        } else {
            throw IllegalArgumentException("⚠️ Error en la verificación del archivo CSV")
        }
    }

    //esto comprueba si esta o no
    private fun existeCSV(archivoCSV: File): Boolean {
        var resultFind: Boolean = false
        print("🔄 Buscando el archivo CSV ")
        when {
            archivoCSV.exists() -> {
                println("✅ Archivo encontrado!")
                resultFind = true
            }
            !archivoCSV.exists() -> {
                throw IllegalArgumentException("⚠️ Archivo no encontrado!")
                resultFind = false
            }
        }
        return resultFind
    }

    //esto comprueba si es legible o no
    private fun legibleCSV(archivoCSV: File): Boolean {
        var resultFind: Boolean = false
        print("🔄 Comprobando el archivo CSV ")
        when {
            archivoCSV.canRead() -> {
                println("✅ Archivo listo para usar!")
                println()
                resultFind = true
            }
            !archivoCSV.canRead() -> {
                throw IllegalArgumentException("⚠️ Archivo no legible, bórralo y añade uno que sí lo sea")
                resultFind = false
            }
        }
        return resultFind
    }

    //analizar el archivo CSV
    fun analizadorCSV(archivoCSV: File): List<Personal> {
        val lectorTextoCSV = archivoCSV.readLines().drop(1)
        return lectorTextoCSV.map { convertirLineaACSV(it) }
    }

    //convertir la linea a CSV
    private fun convertirLineaACSV(linea: String): Personal {
        val campos = linea.split(",")
        return Personal(
            id = campos[0].toInt(),
            nombre = campos[1],
            apellidos = campos[2],
            fechaNacimiento = campos[3],
            fechaIncorporacion = campos[4],
            salario = campos[5].toDouble(),
            pais = campos[6],
            rol = campos[7],
            especialidad = campos[8].ifEmpty { null },
            posicion = campos[9].ifEmpty { null },
            dorsal = campos[10].toIntOrNull(),
            altura = campos[11].toDoubleOrNull(),
            peso = campos[12].toDoubleOrNull(),
            goles = campos[13].toIntOrNull(),
            partidosJugados = campos[14].toIntOrNull()
        )
    }
}