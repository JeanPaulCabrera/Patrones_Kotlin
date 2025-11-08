// ===== OBSERVER - U-Voluntad =====

// Interfaz Observer
interface Observer {
    fun update(event: String)
}

// Sujeto (Actividad)
class ActivitySubject {
    private val observers = mutableListOf<Observer>()

    fun subscribe(observer: Observer) {
        observers.add(observer)
    }

    fun unsubscribe(observer: Observer) {
        observers.remove(observer)
    }

    fun notify(event: String) {
        observers.forEach { it.update(event) }
    }

    fun modifyActivity() {
        println("🔧 La actividad ha sido modificada por el administrador.")
        notify("modified")
    }
}

// Observer 1: Vista del voluntario
class VolunteerActivityView : Observer {
    override fun update(event: String) {
        if (event == "modified") {
            println("📲 Vista actualizada: Se refrescó la lista de actividades.")
        }
    }
}

// Observer 2: Sistema de notificaciones
class NotificationCenter : Observer {
    override fun update(event: String) {
        if (event == "modified") {
            println("🔔 Notificación enviada: La actividad ha cambiado.")
        }
    }
}

// MAIN demostración
fun main() {
    val activity = ActivitySubject()
    val uiView = VolunteerActivityView()
    val notifier = NotificationCenter()

    activity.subscribe(uiView)
    activity.subscribe(notifier)

    // El administrador realiza un cambio
    activity.modifyActivity()
}