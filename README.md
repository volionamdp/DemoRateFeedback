# Cách thêm model vào Project

File `setting.gradle`
thêm
```groovy
repositories {
       maven { url "https://jitpack.io" }
}
```

File `build.gradle` (của model App) `bật dataBiding`
thêm
```groovy
plugins {
    id 'kotlin-kapt'
}
```

```groovy
android{
     dataBinding {
        enabled = true
    }
}
```

# Cách sử dụng


thay đổi dữ liệu trong file `DataRateFeedback`

thay đổi địa chỉ mail trong `Constant.EMAIL_FEEDBACK`

```kotlin
private var rateFeedbackListener = object : RateFeedbackListener {
        override fun onRate(start: Int) {

        }

        override fun onFeedback(position: Int, contentFeedback: String) {

        }

    }
DialogRate(context,rateFeedbackListener).show()   // để show Rate

DialogFeedback(this,rateFeedbackListener).show()  // để show Feedback


```
