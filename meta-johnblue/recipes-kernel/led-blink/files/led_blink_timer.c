#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/init.h>
#include <linux/timer.h>
#include <linux/jiffies.h>

#define BLINK_INTERVAL_MS 1000  // interval in milliseconds

static struct timer_list my_timer;
static bool led_on = false;

void timer_callback(struct timer_list *timer)
{
    led_on = !led_on;
    pr_info("LED is now: %s\n", led_on ? "ON" : "OFF");

    mod_timer(&my_timer, jiffies + msecs_to_jiffies(BLINK_INTERVAL_MS));
}

static int __init timer_init(void)
{
    pr_info("Initializing LED Blink Timer Module\n");

    timer_setup(&my_timer, timer_callback, 0);

    mod_timer(&my_timer, jiffies + msecs_to_jiffies(BLINK_INTERVAL_MS));

    return 0;
}

static void __exit timer_exit(void)
{
    pr_info("Exiting LED Blink Timer Module\n");

    del_timer(&my_timer);
}

module_init(timer_init);
module_exit(timer_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("ChatGPT");
MODULE_DESCRIPTION("A simple Linux kernel timer for blinking LED (simulated).");
