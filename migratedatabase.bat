call ./gradlew.bat :Order:flywayMigrate -P flyway.user=hanos -P flyway.password=password -P flyway.schemas=prodorder -P flyway.url=jdbc:mysql://localhost:3306/prodorder
call ./gradlew.bat :Supplier:flywayMigrate -P flyway.user=hanos -P flyway.password=password -P flyway.schemas=prodsupplier -P flyway.url=jdbc:mysql://localhost:3306/prodsupplier
pause