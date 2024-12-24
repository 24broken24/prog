from django.contrib import admin
from .models import Guide, Tour, Booking

@admin.register(Guide)
class GuideAdmin(admin.ModelAdmin):
    list_display = ('name', 'experience_years')

@admin.register(Tour)
class TourAdmin(admin.ModelAdmin):
    list_display = ('title', 'date', 'price', 'guide')

@admin.register(Booking)
class BookingAdmin(admin.ModelAdmin):
    list_display = ('name', 'email', 'phone', 'tour')
    list_filter = ('tour',)
    search_fields = ('name', 'email', 'phone')
