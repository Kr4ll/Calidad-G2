package com.example.packagemanager.viewControllers
import androidx.test.core.app.ActivityScenario
import androidx.test.runner.AndroidJUnit4
import com.example.packagemanager.R
import com.example.packagemanager.services.StoreService
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId

@RunWith(AndroidJUnit4::class)
class StorehouseAdapterTest {

    private lateinit var scenario: ActivityScenario<StorehouseMenu>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(StorehouseMenu::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun testDeleteStorehouse() {
        // Obtener la vista del botón de eliminar
        onView(withId(R.id.bin_icon2)).perform(click())

        // Comprobar que se eliminó la tienda
        assert(StoreService.findAllStorehouses().size == 0)
    }

}