package net.stonyvin.util

@Singleton
class Logging {
    boolean isLoggingEnabled = true

    void log(String message) {
        if (isLoggingEnabled) {
            println(message)
        }
    }
}
