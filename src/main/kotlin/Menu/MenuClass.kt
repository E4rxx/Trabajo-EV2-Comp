package prog.trbe2.Menu

import prog.trbe2.DisplayStuff.DisplayCLass
import prog.trbe2.filestuff.FileFusioner
import prog.trbe2.csvstuff.FusionReadWrite
import prog.trbe2.filestuff.BuscadorArchivos

class MenuClass {
    val fileFinder = BuscadorArchivos()
    val display = DisplayCLass()
    val fileFusioner = FileFusioner()

    fun displayMenu() {
        println("Opciones disponibles:")
        println("1. Manejar Archivos")
        println("2. Mostrar Archivos")
        println("3. Consultas")
        println("0. Salir")
    }

    fun subdisplayMenu() {
        println("Opciones disponibles:")
        println("1. Crear Archivo Fusionado")
        println("2. Borrar Archivo Fusionado")
        println("0. Salir")
    }

    fun inputIntMenu(x: Int): Int {
        var numtypin: Int?
        do {
            numtypin = readln().toIntOrNull()
            if (numtypin == null) {
                println("⚠️ Solo se adminten números enteros")
            }
        } while (numtypin == null)
        return numtypin
    }

    fun selectOption() {
        var exitmenu = false
        do {
            displayMenu()
            println("Indique la opción:")
            val menuselection = inputIntMenu(1)
            when (menuselection) {
                1 -> subselectOption()
                2 -> {
                    println()
                    println("CSV")
                    display.displayCSV()
                    println()
                    println("JSON")
                    display.displayJSON()
                    println()
                    println("XML")
                    display.displayXML()
                    println()
                    println("Fusion")
                    display.displayFusion()
                }
                3 -> println("Aún no implementado, por desgracia")
                0 -> {
                    exitmenu = true
                    println("See ya, man!")
                }
                else -> println("⚠️ Opción no válida")
            }
        } while (!exitmenu)
    }

    fun subselectOption() {
        val archivoFusion = fileFinder.buscarFusion()
        val fusiondelete = FusionReadWrite()
        var subexitmenu = false
        do {
            subdisplayMenu()
            println("Indique la opción:")
            println()
            val submenuselection = inputIntMenu(1)
            when (submenuselection) {
                1 -> {
                    fileFusioner.mainFileFusioner()
                    subexitmenu = true
                }
                2 -> {
                    fusiondelete.deleteFusionFile(archivoFusion)
                    subexitmenu = true
                }
                3 -> println("Aún no implementado, por desgracia")
                0 -> {
                    subexitmenu = true
                    println("Volviendo al menu principal")
                }
                else -> println("⚠️ Opción no válida")
            }
        } while (!subexitmenu)
    }
}