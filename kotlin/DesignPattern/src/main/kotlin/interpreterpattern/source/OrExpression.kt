package interpreterpattern.source

class OrExpression(private val left: Expression, private val right: Expression) : Expression {
    override fun interpret(): Boolean = left.interpret() || right.interpret()
}