Compose Country Picker Library

If you are looking for an android jetpack compose  library for Country picker or Country Phone Code selector, this is the perfect place for you.

Compose Country Picker  is an android jetpack compose library which provides an easy way to search and select country or country phone code

Language:
English,
Arabic,
Italian,
Russian,
Turkish

How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file


Add it in your root build.gradle at the end of repositories:

	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			        mavenLocal()
                    mavenCentral()
		        	maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.hagarshalaan:composeCountryPicker:Tag'
	}

after just you can just call this code for the country code view 
codeCountryView()
![Screenshot_20240129_020209](https://github.com/hagarshalaan/composeCountryPicker/assets/17965403/0dc21c8a-c7de-47ff-8e71-956ba596fc05)

![Screenshot_20240129_020235](https://github.com/hagarshalaan/composeCountryPicker/assets/17965403/4d0d0978-1f86-4700-b007-94e573287ab3)
#and you can customize the view 
codeCountryView(
    modifier: Modifier = Modifier,
    visibleFullCountry: Boolean = false
)


        codeCountryView(visibleFullCountry = true)
![Screenshot_20240129_020329](https://github.com/hagarshalaan/composeCountryPicker/assets/17965403/37d29b26-94f1-40f5-a690-b3045db00f82)


[![](https://jitpack.io/v/hagarshalaan/composeCountryPicker.svg)](https://jitpack.io/#hagarshalaan/composeCountryPicker)
