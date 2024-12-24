from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', include('tours.urls')),  # Подключаем маршруты из tours/urls.py
]
