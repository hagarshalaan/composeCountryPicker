Compose Country Picker Library

If you are looking for an android jetpack compose  library for Country picker or Country Phone Code selector, this is the perfect place for you.

Compose Country Picker  is an android jetpack compose library which provides an easy way to search and select country or country phone code

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

#and you can customize the view 
codeCountryView(
    modifier: Modifier = Modifier,
    visibleFullCountry: Boolean = false
)


[![](https://jitpack.io/v/hagarshalaan/composeCountryPicker.svg)](https://jitpack.io/#hagarshalaan/composeCountryPicker)
