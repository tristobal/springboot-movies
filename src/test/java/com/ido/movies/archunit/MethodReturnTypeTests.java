package com.ido.movies.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

class MethodReturnTypeTests {

    @Test
    void controllerPublicMethodsShouldReturnLists() {

        JavaClasses importedClasses = new ClassFileImporter()
                .withImportOption(new ImportOption.DoNotIncludeTests())
                .importPackages("com.ido.movies");

        ArchRule myRule = methods()
                .that().areDeclaredInClassesThat().resideInAPackage("..controller..")
                .and().arePublic()
                .should().haveRawReturnType(List.class)
                .because("explanation");

        myRule.check(importedClasses);
    }
}
