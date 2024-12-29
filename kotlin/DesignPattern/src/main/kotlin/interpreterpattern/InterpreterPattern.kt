package interpreterpattern

import interpreterpattern.source.AndExpression
import interpreterpattern.source.BooleanValue
import interpreterpattern.source.OrExpression

fun main() {
    // Boolean Expression ： true AND false OR true
    val expression = OrExpression(
        AndExpression(
            BooleanValue(true),
            BooleanValue(false)
        ),
        BooleanValue(true)
    )

    // 計算結果
    val result = expression.interpret()
    println("Result of the expression is: $result")
}