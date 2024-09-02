# Anotações sobre jUnit

## Anotações Úteis

- `@Test`: especifica que um método é um método de testes
- `@Disable`: desabilita um teste, deve ser utilizado cautelosamente
- `@BeforeAll`: `setup()` - utilizado como configuração, é executado antes dos testes
- `@AfterAll`: `cleanup()` - utilizado para limpar alguma coisa produzida pelos teste, é executada quando os testes terminam
- `@BeforeEach`: é executada antes de cada teste, usado para criar um objeto por exemplo
- `@AfterEach`: é executada depois de cada teste, usado para fechar uma conexão com BD, por exemplo

