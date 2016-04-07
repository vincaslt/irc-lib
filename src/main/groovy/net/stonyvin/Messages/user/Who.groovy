package net.stonyvin.messages.user

import net.stonyvin.messages.Message

class Who extends Message {
    String name

    Who(String name) {
        this.name = name
    }

    @Override
    String toString() {
        return "WHO ${name}"
    }
}
