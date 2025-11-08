// ===== FACTORY METHOD - U-Voluntad =====

// Producto base
abstract class ActivityCard(val name: String) {
    abstract fun render(): String
}

// Productos concretos
class AvailableActivityCard(name: String) : ActivityCard(name) {
    override fun render() = "📌 Actividad disponible: $name  |  [Registrar]"
}

class RegisteredActivityCard(name: String) : ActivityCard(name) {
    override fun render() = "✅ Registrado en: $name  |  [Cancelar]"
}

class InProgressActivityCard(name: String) : ActivityCard(name) {
    override fun render() = "⏳ En progreso: $name  |  [Marcar entrada/salida]"
}

class CompletedActivityCard(name: String) : ActivityCard(name) {
    override fun render() = "🏁 Completada: $name  |  [Ver resumen]"
}

// Factory
object ActivityFactory {
    fun create(type: String, name: String): ActivityCard {
        return when (type.lowercase()) {
            "available" -> AvailableActivityCard(name)
            "registered" -> RegisteredActivityCard(name)
            "progress" -> InProgressActivityCard(name)
            "completed" -> CompletedActivityCard(name)
            else -> throw IllegalArgumentException("Tipo de actividad desconocido")
        }
    }
}

// MAIN demostración
fun main() {
    val activities = listOf(
        ActivityFactory.create("available", "Apoyo en comedor"),
        ActivityFactory.create("registered", "Visita al asilo"),
        ActivityFactory.create("progress", "Caravana solidaria"),
        ActivityFactory.create("completed", "Taller de liderazgo")
    )

    activities.forEach { println(it.render()) }
}
