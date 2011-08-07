A gwt implementation for [Konami code](http://en.wikipedia.org/wiki/Konami_Code).

[Try demo !](http://nfrancois.github.com/KonamiGWTDemo/KonamiGWTDemo.html)

# How use it ?
* Download the library
* Add it to the project classpath
* Add the module to your '.gwt.xml' module file :

```xml
<inherits name='com.googlecode.konamigwt.KonamiGWT' />
```

* Use the api :

```java
new Konami(new KonamiHandler() {
        
        @Override
        public void onKonamiCodePerformed() {
                Window.alert("You win");
                
        }
}).start();
```