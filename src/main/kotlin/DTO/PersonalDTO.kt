package prog.trbe2.DTO

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

@Serializable
data class Personal(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("nombre")
    val nombre: String? = "",
    @SerialName("apellidos")
    val apellidos: String = "",
    @SerialName("fecha_nacimiento")
    val fechaNacimiento: String? = "",
    @SerialName("fecha_incorporacion")
    val fechaIncorporacion: String? = "",
    @SerialName("salario")
    val salario: Double? = 0.0,
    @SerialName("pais")
    val pais: String = "",
    @SerialName("rol")
    val rol: String,
    @SerialName("especialidad")
    val especialidad: String? = "",
    @SerialName("posicion")
    val posicion: String? = "",
    @SerialName("dorsal")
    val dorsal: Int? = 0,
    @SerialName("altura")
    val altura: Double? = 0.0,
    @SerialName("peso")
    val peso: Double? = 0.0,
    @SerialName("goles")
    val goles: Int? = 0,
    @SerialName("partidos_jugados")
    val partidosJugados: Int? = 0
)

data class PersonalXML(
    @JacksonXmlProperty(localName = "id") val id: Int,
    @JacksonXmlProperty(localName = "nombre") val nombre: String,
    @JacksonXmlProperty(localName = "apellidos") val apellidos: String,
    @JacksonXmlProperty(localName = "fecha_nacimiento") val fechaNacimiento: String?,
    @JacksonXmlProperty(localName = "fecha_incorporacion") val fechaIncorporacion: String?,
    @JacksonXmlProperty(localName = "salario") val salario: Double?,
    @JacksonXmlProperty(localName = "pais") val pais: String,
    @JacksonXmlProperty(localName = "tipo") val rol: String,
    @JacksonXmlProperty(localName = "especialidad") val especialidad: String?,
    @JacksonXmlProperty(localName = "posicion") val posicion: String?,
    @JacksonXmlProperty(localName = "dorsal") val dorsal: Int?,
    @JacksonXmlProperty(localName = "altura") val altura: Double?,
    @JacksonXmlProperty(localName = "peso") val peso: Double?,
    @JacksonXmlProperty(localName = "goles") val goles: Int?,
    @JacksonXmlProperty(localName = "partidos_jugados") val partidosJugados: Int?
)
