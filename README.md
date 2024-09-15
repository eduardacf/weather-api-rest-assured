# 🌤️ Weather API Testing with RestAssured

Este projeto demonstra como testar a API pública OpenWeather usando **RestAssured** e **JUnit**. O objetivo é validar várias funcionalidades da API, como busca de clima atual, previsões e parâmetros adicionais.

## 🚀 Configuração

1. Clone o repositório:

```bash
  git clone https://github.com/eduardacf/weather-api-rest-assured.git

```
2. Navegue até o diretório:

```bash
  cd weather-api-rest-assured

```
3. Configure sua chave de API do OpenWeather:

	- Registre-se no OpenWeather para obter uma API key.
	- Adicione sua API key no código ou em um arquivo de propriedades.
	- Instale as dependências e compile:
	
```bash
./gradlew build
```
## 🛠️ Tecnologias Utilizadas
- Java 17 ☕
- RestAssured 5.5.0 🌐
- JUnit 5 📘
- Gradle 🛠️
## 🧪 Testes Implementados
- **Testes básicos de clima:** Verificam a resposta ao buscar clima por nome de cidade.

- **Testes de dados meteorológicos:** Validam informações como temperatura, vento e umidade.

- **Testes de previsões:** Conferem a precisão de previsões de 5 dias.

- **Testes de erro:**  Verificam respostas de erro como códigos 401 (não autorizado).

## ⚡ Executar os Testes

Execute os testes via Gradle:

```bash
./gradlew test
```
