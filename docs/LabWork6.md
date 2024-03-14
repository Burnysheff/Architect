Замечание: на диаграммах курсовом помечены переопределямые методы.
# GoF паттерны
## Порождающие паттерны
### Фабричный метод
Паттерн фабричный метод позволяет создавать объекты, динамически определяя их класс. 
Согласно паттерну, класс-родитель перекладывает обязанность по созданию объектов на классы-наследники, которые создают объект нужного типа.
Благодаря этому, достигается лучшая гибкость кода, а также обеспечивается удобство добавления новых типов объектов.
**Пример использования паттерна:**
```java
public interface Rule {
	String check();
}

public class ObligatoryRule implements Rule {

	@Override
	public String check() {
		return "Obligatory";
	}
}

public class SimpleRule implements Rule {

	@Override
	public String check() {
		return "Obligatory";
	}
}

public abstract class Checker {
	private void runCheck() {
		Rule rule = createRules();
		rule.check();
	}
	protected abstract Rule createRules();
}

public class ObligatoryChecker extends Checker {

	@Override
	protected Rule createRules() {
		return new ObligatoryRule();
	}
}

public class SimpleChecker extends Checker {

	@Override
	protected Rule createRules() {
		return new SimpleRule();
	}
}

// Использование в клиентском коде
Checker checker = new SimpleChecker();
checker.runCheck();
```
**Диаграмма использования:**

**Объяснение:** интерфейс Rule - общий интерфейс всех возможных правил, SimpleRule и ObligatoryRule - его потомки с разной реализацией check(). 
Checker - общий класс для проверок.
Для проверок нужно создать правило, для этого существуют SimpleChecker и obligatoryChecker, они переопределяют создание правила, возвращая разный тип. 
Впоследствии при вызове runCheck() у Checker будет выполняться именно нужная логика.

### Прототип
Паттерн прототип позволяет выполнять клонирование объектов, не привязываясь к их конкретным реализациям. 
Он также увеличивает читаемость кода, так отпадает необходимость выполнять ручное клонирование объектов каждый раз, когда это требуется.
