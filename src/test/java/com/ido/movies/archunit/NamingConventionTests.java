package com.ido.movies.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

class NamingConventionTests {

    private JavaClasses importedClasses;

    @BeforeEach
    void setUp() {
        importedClasses = new ClassFileImporter()
                .withImportOption(new ImportOption.DoNotIncludeTests())
                .importPackages("com.ido.movies");
    }

    @Test
    void controllersShouldBeSuffixed() {
        ArchRule myRule = classes()
                .that().resideInAPackage("..controller..")
                .should().haveSimpleNameEndingWith("Controller");

        myRule.check(importedClasses);
    }

    @Test
    void restControllersShouldBeLocatedControllerPackage() {
        ArchRule myRule = classes()
                .that().areAnnotatedWith(RestController.class)
                .should().resideInAPackage("..controller..");

        myRule.check(importedClasses);
    }
}
