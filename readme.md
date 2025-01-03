# Stream
[![](https://jitpack.io/v/Antritus/Stream.svg)](https://jitpack.io/#Antritus/Stream)

```groovy
	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
	
	
	dependencies {
	        implementation 'com.github.Antritus:Stream:1.0.6'
	}
```

## For developers wanting to use the API
```java
import bet.astral.stream.economy.Economy;
import bet.astral.stream.permission.Permission;
import bet.astral.stream.style.Style;
import bet.astral.stream.utils.Player;
import bet.astral.text.api.component.Component;

public class MyThingy {
    public void playerDoSomething(Player/PlayerEntity playerRef){
        Player player = (Player) playerRef;
        Economy economy = Stream.getEconomy();
        double balance = economy.getBalance(player);

        player.sendMessage(Component.text("Your current balance is now: "+ economy));
        player.sendMessage("Hello!!!");

        Style style = Stream.getStyle();
        player.sendMessage(style.getPrefix(player), style.getNickname(player), style.getSuffix(player), Component.text(": Hello!"));

        Permission permission = Stream.getPermission();
        if (permission.hasPermission(player.getId(), "Player")){
            player.sendMessage("HAS PERMISSION YIPPIE");
        }

        if (playerRef instanceof Player player && player.hasPermission("player.permission")) {
            player.sendMessage("YES YES YES");
        } else {
            player.sendMessage("NO NO NO");
        }
    }
}

```

## For developers wanting to create an "addon"
```java
import bet.astral.stream.economy.Currency;
import bet.astral.stream.economy.CurrencyEconomy;
import bet.astral.stream.economy.Economy;
import bet.astral.stream.economy.EconomyProvider;
import bet.astral.stream.permission.Permission;
import bet.astral.stream.permission.PermissionProvider;
import bet.astral.stream.style.Style;
import bet.astral.stream.style.StyleProvider;

public class MyThingy implements EconomyProvider, PermissionProvider, StyleProvider {

    @Override
    public Economy getEconomy() {
        return null;
    }

    @Override
    public CurrencyEconomy getEconomy(Currency currency) {
        return null;
    }

    @Override
    public void registerEconomy(Currency currency) {

    }

    @Override
    public Economy getEconomy(String worldId) {
        return null;
    }

    @Override
    public CurrencyEconomy getEconomy(Currency currency, String worldId) {
        return null;
    }

    @Override
    public void registerEconomy(Currency currency, String worldId) {

    }

    @Override
    public void unhookEconomy() {

    }

    @Override
    public Permission getPermission() {
        return null;
    }

    @Override
    public Permission getPermissionFromWorld(String worldId) {
        return null;
    }

    @Override
    public void unhookPermission() {

    }

    @Override
    public Style getStyle() {
        return null;
    }

    @Override
    public Style getStyleFromWorld(String world) {
        return null;
    }

    @Override
    public void unhookStyle() {

    }
}

```