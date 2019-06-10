$(document).ready(function() {
  $('.custom-range button').click(function() {
    console.log('change range button has been clicked');
    $('.custom-range form').toggle();
  });
  $('[name="userRange"]').click(function() {
    $(this).hide();
    console.log(this, ' got hidden');
  });
});
