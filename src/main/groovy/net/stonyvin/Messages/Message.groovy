package net.stonyvin.Messages

abstract class Message {
    abstract String translateResponse(int responseCode)
    abstract String toString()
}
