package interpreterpattern.source

class BooleanValue(private val value: Boolean) : Expression {
    override fun interpret(): Boolean = value
}