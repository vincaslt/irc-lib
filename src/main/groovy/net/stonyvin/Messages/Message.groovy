package net.stonyvin.messages

abstract class Message {
    abstract String translateResponse(int responseCode)
    abstract String toString()
}
