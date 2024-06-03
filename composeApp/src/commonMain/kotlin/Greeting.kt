class Greeting {
    private val platform = getPlatform()

    fun hello(): String {
        return "Hello, ${platform.name}!"
    }
}