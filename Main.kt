fun main() {
    println("Введіть кількість працівників:")
    val count = readLine()?.toIntOrNull() ?: return println("Некоректне число!")

    val bonuses = mutableListOf<Pair<String?, Double>>()

    repeat(count) { i ->
        println("Працівник #${i + 1}")

        print("Ім’я: ")
        val name = readLine()?.takeIf { it.isNotBlank() }

        print("Оклад: ")
        val salary = readLine()?.toDoubleOrNull()
        if (salary == null || salary < 0) {
            println("Помилка: Некоректний оклад.")
            return
        }

        print("Коефіцієнт бонусу (0.1 до 2.0): ")
        val bonusRate = readLine()?.toDoubleOrNull()
        if (bonusRate == null || bonusRate !in 0.1..2.0) {
            println("Помилка: Некоректний коефіцієнт бонусу.")
            return
        }

        val bonus = salary * bonusRate
        bonuses.add(name to bonus)
    }

    if (bonuses.isEmpty()) return println("Даних немає.")

    val maxBonus = bonuses.maxByOrNull { it.second }
    val totalBonus = bonuses.sumOf { it.second }
    val excellentCount = bonuses.count { it.second >= 10000 }

    println("\nНайбільший бонус отримає: ${maxBonus?.first ?: "Невідомо"} - ${maxBonus?.second}")
    println("Загальна сума бонусів: $totalBonus")
    println("Кількість \"відмінних\" працівників (бонус ≥ 10000): $excellentCount")
}
