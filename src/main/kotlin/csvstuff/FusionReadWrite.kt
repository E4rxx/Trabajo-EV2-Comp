package prog.trbe2.csvstuff

import java.io.File

class FusionReadWrite() {
    //la funcion principal de esta clase
    //esto busca el archivo fusionado
    // y si no lo encuentra lo crea
    fun mainReadFusion(archivoFusion: File): File {
        existeFusion(archivoFusion)
        return archivoFusion
    }

    //Esta funcion es como la del csv pero para el archivo fusionado
    fun mainReadNewFusion(archivoFusion: File): File {
        if (existeNewFusion(archivoFusion) && legibleNewFusion(archivoFusion)) {
            return archivoFusion
        } else {
            throw IllegalArgumentException("⚠️ Error en la verificación del archivo CSV")
        }
    }

    //esto comprueba si esta o no
    private fun existeFusion(archivoFusion: File): Boolean {
        var resultFind: Boolean = false
        print("🔄 Buscando el archivo fusionado ")
        when {
            archivoFusion.exists() -> {
                println("⚠️ Archivo encontrado. Se borrará y creara uno desde cero")
                println()
                archivoFusion.delete()
                resultFind = true
            }
            !archivoFusion.exists() -> {
                println("✅️ Archivo no encontrado!")
                println()
                crearFusion(archivoFusion)
                resultFind = false
            }
        }
        return resultFind
    }

    //crear archivo fusionado
    private fun crearFusion(archivoFusion: File) {
        print("🔄 Creando archivo fusionado ")
        if (archivoFusion.createNewFile()) {
            println("✅ Archivo creado!")
        } else {
            throw IllegalArgumentException("⚠️ Error al crear el archivo de fusión")
        }
    }

    //esto comprueba si esta el nuevo archivo o no. esto es como el csv pero para el archivo fusionado
    private fun existeNewFusion(archivoFusion: File): Boolean {
        var resultFind: Boolean = false
        print("🔄 Buscando el archivo fusionado ")
        when {
            archivoFusion.exists() -> {
                println("✅ Archivo encontrado!")
                resultFind = true
            }
            !archivoFusion.exists() -> {
                throw IllegalArgumentException("⚠️ Tienes que ejecutar la opcion uno primero, de lo contrario esta excepción se lanzará")
                resultFind = false
            }
        }
        return resultFind
    }

    //esto comprueba si el nuevo archivo es legible o no. esto es como el csv pero para el archivo fusionado
    private fun legibleNewFusion(archivoFusion: File): Boolean {
        var resultFind: Boolean = false
        print("🔄 Comprobando el archivo fusionado ")
        when {
            archivoFusion.canRead() -> {
                println("✅ Archivo listo para usar!")
                println()
                resultFind = true
            }
            !archivoFusion.canRead() -> {
                throw IllegalArgumentException("⚠️ Archivo no legible, ejecuta el programa de nuevo para que se cree uno que sí valga")
                resultFind = false
            }
        }
        return resultFind
    }

    fun deleteFusionFile(archivoFusion: File): Boolean {
        var resultFind: Boolean = false
        print("🔄 Buscando el archivo fusionado ")
        when {
            archivoFusion.exists() -> {
                println("✅ Archivo encontrado y borrado!")
                println()
                archivoFusion.delete()
                resultFind = true
            }
            !archivoFusion.exists() -> {
                println("✅️ Archivo no encontrado!")
                println()
                resultFind = false
            }
        }
        return resultFind
    }
}