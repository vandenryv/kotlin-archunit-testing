import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition

@AnalyzeClasses(packagesOf = [ArchUnitKotlinTest::class])
class ArchUnitKotlinTest {

    @ArchTest
    val rule_as_field = ArchRuleDefinition.noClasses()
        .that().resideInAPackage("org.hexavote.domain")
        .should().dependOnClassesThat()
        .resideOutsideOfPackages(
            "org.hexavote.domain..",
            "..common..",
            "java..", // List and stuff
            "kotlin..", // Kotlin stuff
            "org.jetbrains.." // Adaptive layer between Kotlin and JVMs
        )

    @ArchTest
    fun rule_as_method(importedClasses: JavaClasses) {
        val rule = ArchRuleDefinition.noClasses()
            .that().resideInAPackage("org.hexavote.domain")
            .should().dependOnClassesThat()
            .resideOutsideOfPackages(
                "org.hexavote.domain..",
                "..common..",
                "java..", // List and stuff
                "kotlin..", // Kotlin stuff
                "org.jetbrains.." // Adaptive layer between Kotlin and JVMs
            )
        rule.check(importedClasses)
    }
}