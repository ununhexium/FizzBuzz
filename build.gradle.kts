group = "net.lab0.fizzbuzz"
version = "0.0.1"

buildscript {
  repositories {
    jcenter()
    mavenCentral()
  }
}

repositories {
  mavenCentral()
  jcenter()
}

plugins {
  kotlin("jvm") version "1.4.30"

  application
}

dependencies {
  // TEST

  testImplementation("org.junit.jupiter:junit-jupiter:5.5.2")
}

tasks {
  test {
    useJUnitPlatform()
  }
}
