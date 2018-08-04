(function($) {
  $(function() {

    $('.sidenav').sidenav();
    $('.parallax').parallax();
    $('.slider').slider();
    $('.modal').modal();

    $('.carousel.carousel-slider').carousel({
      fullWidth: false,
      indicators: true
    });

  }); // end of document ready
})(jQuery); // end of jQuery name space
