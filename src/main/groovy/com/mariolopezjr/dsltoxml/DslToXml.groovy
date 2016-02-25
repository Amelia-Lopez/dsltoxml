package com.mariolopezjr.dsltoxml

import groovy.xml.MarkupBuilder
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer

class DslToXml {

    static void main(String... args) {
        println createXmlFromDslString("/email.groovy")
    }

    def static Object createXmlFromDslString(String fileName) {
        def dslString = this.getClass().getResource(fileName).text

        def config = new CompilerConfiguration()
        config.scriptBaseClass = MarkupBuilderScript.name

        def imports = new ImportCustomizer()
        imports.addStarImports(DslToXml.class.package.name)
        config.addCompilationCustomizers(imports)

        def shell = new GroovyShell(this.class.classLoader, config)
        shell.evaluate(dslString + '\n toString()')  // todo: this concatenation is super hacky
    }
}

abstract class MarkupBuilderScript extends Script {
    def writer = new StringWriter()
    MarkupBuilder markupBuilder = new MarkupBuilder(writer)

    def methodMissing(String name, args) { markupBuilder.invokeMethod(name, args) }

    def String toString() { writer.toString() }
}