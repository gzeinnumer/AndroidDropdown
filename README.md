<h1 align="center">
<img src="https://github.com/gzeinnumer/AndroidDropdown/blob/master/preview/example2.jpg" width="300"/>

</h1>

<h1 align="center">
  AndroidDropdown - Easy AutoTextView
</h1>

<div align="center">
    <a><img src="https://img.shields.io/badge/Version-2.0.0-brightgreen.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/ID-gzeinnumer-blue.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/Java-Suport-green?logo=java&style=flat"></a>
    <a><img src="https://img.shields.io/badge/Kotlin-Suport-green?logo=kotlin&style=flat"></a>
    <a href="https://github.com/gzeinnumer"><img src="https://img.shields.io/github/followers/gzeinnumer?label=follow&style=social"></a>
    <br>
    <p>Simple way to use AutoTextView</p>
</div>

---
# Content List
* [Download](#download)
* [Feature List](#feature-list)
* [Usage](#usage)
* [Example Code/App](#example-codeapp)
* [Version](#version)
* [Contribution](#contribution)

---
# Download
Add maven `jitpack.io` and `dependencies` in `build.gradle (Project)` :
```gradle
// build.gradle project
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

// build.gradle app/module
dependencies {
  ...
  implementation 'com.github.gzeinnumer:AndroidDropdown:version'
}
```

---
# Feature List
- [x] [AutoTextView](#AutoTextView)

---
# Usage

### AutoTextView

- Widget on `xml`
```xml
<com.google.android.material.textfield.TextInputLayout
    style="@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox.ExposedDropdownMenu"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="Hint AutoCompleteTextView">

    <AutoCompleteTextView
        android:id="@+id/act"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:editable="false"
        android:inputType="none" />
</com.google.android.material.textfield.TextInputLayout>
```

if you want to custom your `AutoCompleteTextView` use `style="@style/AutoCompleteTextViewStyle"` on view, and make style on your `res->value->style.xml`
```xml
<resources xmlns:tools="http://schemas.android.com/tools">

    <style name="AutoCompleteTextViewStyle">
        <item name="android:textSize">36sp</item>
        <item name="android:textColor">#000000</item>
    </style>
</resources>
```
```java
adapter.setItemStyle(R.style.AutoCompleteTextViewStyle);
```

#
- **Content Item** there is 2 type list that you can sent to this `AutoCompleteTextView`.

**Type 1**
```java
AutoCompleteTextView act = findViewById(R.id.act);

ArrayList<String> listString = new ArrayList<String>();
listString.add("Satu");
listString.add("Dua");
listString.add("Tiga");
listString.add("Empat");

AdapterAutoCompleteText<String> adapter = new AdapterAutoCompleteText<String>(getApplicationContext(), listString);
//adapter.setItemStyle(R.style.AutoCompleteTextViewStyle);
act.setAdapter(adapter);

act.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        act.setText(listString.get(position).toString(), false);
    }
});
```

**Type 2** for this type you should override function `toString()` in your `model pojo`
```java
public class ExampleModel {

    private int id;
    private String name;
    private String address;

    //constructor

    //getter
    //setter

    @Override
    public String toString() {
        return "ExampleModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
```
Use your own model. And dont forget to declare your `model pojo` in `Declaration`. Example `AdapterAutoCompleteText<ExampleModel>(getApplicationContext(), listObject);`
```java
AutoCompleteTextView act = findViewById(R.id.act);

ArrayList<ExampleModel> listObject = new ArrayList<>();
listObject.add(new ExampleModel(1, "Zein", "Balbar"));
listObject.add(new ExampleModel(2, "Zein2", "Balbar2"));
listObject.add(new ExampleModel(3, "Zein3", "Balbar3"));
listObject.add(new ExampleModel(4, "Zein4", "Balbar4"));

AdapterAutoCompleteText<ExampleModel> adapter = new AdapterAutoCompleteText<ExampleModel>(getApplicationContext(), listObject);
//adapter.setItemStyle(R.style.AutoCompleteTextViewStyle);
act.setAdapter(adapter);

act.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        act.setText(listObject.get(position).toString(), false);
    }
});
```

#

**Preview** :

| <img src="https://github.com/gzeinnumer/AndroidDropdown/blob/master/preview/example1.jpg"/>| <img src="https://github.com/gzeinnumer/AndroidDropdown/blob/master/preview/example2.jpg"/> |<img src="https://github.com/gzeinnumer/AndroidDropdown/blob/master/preview/example3.jpg"/> |
|:---|:---|:---|

---
# Example Code/App

**FullCode [MainActivity](https://github.com/gzeinnumer/AndroidDropdown/blob/master/app/src/main/java/com/gzeinnumer/AndroidDropdown/MainActivity.java) & [ExampleModel](https://github.com/gzeinnumer/AndroidDropdown/blob/master/app/src/main/java/com/gzeinnumer/AndroidDropdown/ExampleModel.java) & [XML](https://github.com/gzeinnumer/AndroidDropdown/blob/master/app/src/main/res/layout/activity_main.xml)**

[Sample Code And App](https://github.com/gzeinnumer/MyLibAutoTextViewExample)

---
# Version
- **1.0.0**
  - First Release
- **1.0.3**
  - Bug Fixed
- **1.0.4**
  - Bug Fixed
- **2.0.0**
  - Supoert SDK 16

---
# Contribution
You can sent your constibution to `branch` `open-pull`.

---

```
Copyright 2020 M. Fadli Zein
```
