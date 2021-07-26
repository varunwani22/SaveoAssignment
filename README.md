<h1>Saveo</h1>
<p>This is the assignment given by Saveo</p>
<hr>
<h3>Used Technologies</h3>
<ul>
  <li>Kotlin</li>
  <li>MVVM</li>
  <li>Retrofit</li>
  <li>Recycler View</li>	
  <li>Lottie Animation</li>
</ul>  
<hr>

<h3>Network Link</h3>
<p>https://api.tvmaze.com/shows?page=1</p>
<hr>

<h3>Dependencies</h3>
<hr>

	  //dimens
    implementation 'com.intuit.sdp:sdp-android:1.0.6'

    // Lifecycle
    implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"

    //Glide
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
    // Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation "com.squareup.okhttp3:logging-interceptor:4.0.1"
    // Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.3'

    //lottie
    implementation 'com.airbnb.android:lottie:3.0.6'
