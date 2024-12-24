from django.shortcuts import render, get_object_or_404, redirect
from .models import Tour
from .forms import BookingForm

def tour_list(request):
    tours = Tour.objects.all()
    return render(request, 'tours/tour_list.html', {'tours': tours})

def tour_detail(request, pk):
    tour = get_object_or_404(Tour, pk=pk)
    form = BookingForm(request.POST or None)
    if form.is_valid():
        booking = form.save(commit=False)
        booking.tour = tour
        booking.save()
        return redirect('tour_list')  # После записи возвращаемся на главную
    return render(request, 'tours/tour_detail.html', {'tour': tour, 'form': form})
