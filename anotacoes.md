# Anotações sobre jUnit

## Testes Parametrizados

Servem para realizar um mesmo teste para diferente conjuntos de inputs.
O teste abaixo:
```java
@Test
@DisplayName("Test 2 / 6 = 0.333...")
void testDivision_When_TwoDividedBySix_ShouldReturn_ZeroDotThreeThreeThreeAndSoOn() {
    // Given / Arrange
    double firstValue = 6.2d;
    double secondValue = 2d;
    double expected = 3.1d;

    // When / Act
    double actual = math.division(firstValue, secondValue);

    // Then / Assert
    assertEquals(expected, actual, EPSILON, "The testDivision() did not produce expected result");
}
```

Pode ser parametrizado da seguinte maneira:
```java
static Stream<Arguments> testDivisionInputParameters() {
    // Given / Arrange
    return Stream.of(
            Arguments.of(6.2d, 2d, 3.1d),
            Arguments.of(71d, 14d, 5.071d),
            Arguments.of(18.3d, 3.1d, 5.903d)
    );
}

@ParameterizedTest
@MethodSource("testDivisionInputParameters")
void testDivision(double firstValue, double secondValue, double expected) {
    // When / Act
    double actual = math.division(firstValue, secondValue);

    // Then / Assert
    assertEquals(expected, actual, EPSILON, "The testDivision() did not produce expected result");
}
```

Caso a função que provê os valores tenha o mesmo nome dos testes, podemos omitir o nome da função no @MethodSource:
```java
static Stream<Arguments> testDivision() {
    // Given / Arrange
}

@ParameterizedTest
@MethodSource
void testDivision(double firstValue, double secondValue, double expected) {
    // When / Act
    // Then / Assert
}
```

Também é possível parametrizar um teste com a anotação `@CsvSource` da seguinte maneira:
```java
@ParameterizedTest
@CsvSource({
        "6.2, 2, 8.2",
        "5.1, -3.4, 1.7",
        "2, -5.2, -3.2"
})
void testSum(double firstValue, double secondValue, double expected) {
    // When / Act
    double actual = math.sum(firstValue, secondValue);

    // Then / Assert
    assertEquals(expected, actual, EPSILON, "The testSum() did not produce expected result");
}
```

Ou utilizar um arquivo csv:
```java
@ParameterizedTest
@CsvFileSource(resources = "/testFiles/testSubtraction.csv")
void testSubtraction(double firstValue, double secondValue, double expected) {
    // When / Act
    double actual = math.subtraction(firstValue, secondValue);

    // Then / Assert
    assertEquals(expected, actual, EPSILON, "The testSubtraction() did not produce expected result");
}
```

## Repetindo Testes

- Trocando a anotação `@Test` por `@RepeatedTest(<N>)` fazemos com que o teste seja executado por N vezes

É possível pegar informações sobre a repetição adicionando um parâmetro ao metodo:
```java
@RepeatedTest(value = 3, name = "{displayName}. Repetition {currentRepetition} of {totalRepetitions}")
void testSample(RepetitionInfo repetitionInfo, TestInfo testInfo) {
    System.out.println("Repetition N° " + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
    
    System.out.println("Running " + testInfo.getTestMethod().get().getName());
}
```

## Ordem de Testes

- A ordem que os testes são feitas pode ser alterada com a anotação `@TestMethodOrder(MethodOrderer.<classe de ordenação>.class)`.
- As classes de ordenação existentes são:
    - MethodName;
    - Random;
    - OrderAnnotation - é necessário anotas os metodos com `@Order(<numero>)`. 

- Ordenar randomicamente é desejável na maioria das vezes, quando não queremos que um teste dependa de outro
- Ordenar por índice é utilizado para testes de integração

## Ciclo de Vida dos Testes no JUnit

- Por padrão, o ciclo de vida da instância de testes "por método"
- O JUnit cria uma instancia para cada teste que temos em uma classe de testes, os testes são executados separadamente, esse é o comportamento padrão
- Esse comportamento pode ser alterado, fazendo com que todos os teste sejam executados em uma única instancia

Para alterar o ciclo de vida padrão, basta adicionar a anotação `@TestInstance(TestInstance.Lifecycle.PER_CLASS)`

## Anotações Bases

- `@Test`: especifica que um método é um método de testes
- `@BeforeAll`: `setup()` - utilizado como configuração, é executado antes dos testes
- `@AfterAll`: `cleanup()` - utilizado para limpar alguma coisa produzida pelos teste, é executada quando os testes terminam
- `@BeforeEach`: é executada antes de cada teste, usado para criar um objeto por exemplo
- `@AfterEach`: é executada depois de cada teste, usado para fechar uma conexão com BD, por exemplo

## Anotações Úteis

- `@Disable`: desabilita um teste, deve ser utilizado cautelosamente
- `@DisplayName("<nome do teste>")`: altera o nome mostrado do teste
- `@ParameterizedTest` e `@MethodSource("<nome do método>")`: para realizar o mesmo teste para diferentes inputs

