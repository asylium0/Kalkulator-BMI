## Błąd 1
F:\Android\Projects\KalkulatorBMI\app\src\main\java\com\example\kalkulatorbmi\MainActivity.java:36: error: cannot find symbol
tvBMICategory = findViewById(R.id.asdasd);
^
symbol:   variable asdasd
location: class id

## Błąd 2
FATAL EXCEPTION: main
Process: com.example.kalkulatorbmi, PID: 3282
java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.TextView.setText(java.lang.CharSequence)' on a null object reference
at com.example.kalkulatorbmi.MainActivity.Calculate(MainActivity.java:71)
at com.example.kalkulatorbmi.MainActivity.lambda$onCreate$1$com-example-kalkulatorbmi-MainActivity(MainActivity.java:39)

## Błąd 3 
Przy braku .show() przy Toast nie dzieje się po prostu nic i Toast nie jest wyświetlany