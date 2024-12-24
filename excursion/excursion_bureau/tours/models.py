from django.db import models

class Guide(models.Model):
    name = models.CharField(max_length=100)
    bio = models.TextField()
    experience_years = models.IntegerField()

    def __str__(self):
        return self.name

class Tour(models.Model):
    title = models.CharField(max_length=100)
    description = models.TextField()
    date = models.DateField()
    duration_hours = models.FloatField()
    price = models.DecimalField(max_digits=10, decimal_places=2)
    guide = models.ForeignKey(Guide, on_delete=models.CASCADE)

    def __str__(self):
        return self.title

class Booking(models.Model):
    tour = models.ForeignKey(Tour, on_delete=models.CASCADE)
    name = models.CharField(max_length=100)
    email = models.EmailField()
    phone = models.CharField(max_length=20)

    def __str__(self):
        return f"{self.name} - {self.tour.title}"
