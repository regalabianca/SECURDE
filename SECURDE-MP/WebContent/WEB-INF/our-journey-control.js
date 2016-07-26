(function() {
	$('.tg-btn-countinuereading').click(function(){
		console.log("hi");
	});
	
	displayArticle({img_source: "img/alone.jpg" , date: "May 27, 2016", author: "Bianca Regala", title: "Finding Peace in Paxos, Greece", content: "<p> Kalimera!!! Good morning in Greek, this was my favorite way to start each and every day for the 2 weeks I was in Greece in June. Well, that along with an iced cappuccino and a giant bowl of Greek yogurt topped with fruit and honey. So flippin’ tasty! </p><p>Hot off the boat from traveling from Brindisi, Italy to Corfu, Greece, I knew I needed to schedule in some alone time away from large groups of people, preferably on a secluded beautiful beach before starting up another hectic month and a half of Euro travels. Not to mention I was glow-in-the-dark pale. My poor skin needed some sunshine! </p><p> Trying to pick the perfect island in Greece to visit is like looking for a needle in a haystack. With 1,400 to chose from, I could only start researching for about 5 minutes before my ADD kicked in and my head wanted to explode. Lucky for me, Lonely Planet still publishes photos in their print guide books, and once I saw this photo of Paxos, I knew that was the island for me.</p>"});
	displayArticle({img_source: "img/calm.jpg" , date: "May 16, 2016", author: "Raisa Lee", title: "My First Real Vacation in Bali", content: "<p>	I fell in love with diving this year on my first trip to Queensland, Australia, and since I got my PADI open water certification, I have been itching to get back into the water as often as possible to improve. This was probably my main reason for stopping over in Bali, and after doing some research I settled on Amed as my first dive spot. I knew I was going to tug on a wetsuit and jump in as many days as I could on the trip. With easy to access dive sites, calm currents and awesome reefs, this was going to be a great place to improve. </p> <p> After doing some research on Tripadvisor, I settled on Adventure Divers Bali, and wandered into their shop/homestay as soon as I arrived in Amed. They blew me away. I signed up for 4 dives over 2 days, and couldn’t have been happier. </p>"});
	displayArticle({img_source: "img/bent.jpg" , date: "May 3, 2016", author: "Camille Saavedra", title: "Stepping back in time in Hydra, Greece", content: "<p>	While so many islands in Greece are being slowly conquered by foreigners (cough, cough Santorini and Mykonos, I’m looking at you two), it’s great to know that there are plenty beautiful islands held firmly in the hands of Greeks. As soon as I read about Hydra last summer, I knew I had to make it a stop on my itinerary through Greece, and I wasn’t disappointed!</p> <p> When there are so many islands to chose from to visit in Greece, for me at least, it was hard to pinpoint down which ones to visit. Two important things about Hydra struck me, and as fate would have it, they were the two things I loved most about the island. </p> <p> Prepare to be shocked. </p>"});
	displayArticle({img_source: "img/hut.jpg" , date: "April 21, 2016", author: "Richelle Chua", title: "Sleeping under the stars on the Great Barrier Reef", content: "<p>	Exciting news everyone, in one week exactly I’ll be boarding a plane back to Australia! And no, I’m not getting deported from New Zealand as I originally feared, rather I am embarking on an awesome new adventure in Tropical North Queensland, one of my favorite regions!I can’t wait!</p> <p> But more on that later, while I have been getting ready I found myself reminiscing about the first time I was in the Whitsundays, and I realized I haven’t even told the full story of my favorite activity on my blog. For shame! </p>"});
	displayArticle({img_source: "img/rock.jpg" , date: "April 1, 2016", author: "Robee Te", title: "Tales by Light in Byron Bay, Australia", content: "<p>	Byron Bay, where have you been all my life?</p> <p> At the end of my big trip a few months ago, I found myself coming back to New Zealand via Australia, a usual stop on long-haul flights between this part of the world and Europe. While more often than not when I am in Australia, I am in Queensland, an area that I love and know pretty well, so I was really excited this time around when I got the chance to check out Byron Bay for the first time with Canon.</p>"});
	
	$('.article-modal-content').css('height', window.innerHeight*0.9);
	$('.article-modal-content .tg-post-content .description').css('height', window.innerHeight*0.6);
})();

function displayArticle(article){
	var image_source = article.img_source;
	var date = article.date;
	var author = article.author;
	var title = article.title;
	var content = article.content;
	
	var article_content = 
	'<article class="tg-post">' +
	'	<figure>' +
	'		<div id="instagram-gallery" class="instagram-gallery">' +
	'			<div class="item">' +
	'				<img src="' + image_source + '" alt="image description">' +
	'			</div>' +
	'		</div>' +
	'	</figure>' +
	'	<div class="tg-post-content">' +
	'		<div class="post-meta category-name">' +
	'			<span class="date">' + date + '</span>' +
	'		</div>' +
	'		<h3><a href="#">' + title + '</a></h3>' +
	'		<div class="post-meta">' +
	'			<span><a href="#">' + author + '</a></span>' +
	'		</div>' +
	'		<div class="description">' + content +'</div>' +
	'		<a href="#" class="tg-btn-countinuereading" data-toggle="modal" data-target=".bs-example-modal-lg">countinue reading</a>' +
	'		<div class="tg-post-foot">' +
	'			<ul class="post-social-icons pull-left">' +
	'				<li><a href="#"><i class="fa fa-facebook"></i></a></li>' +
	'				<li><a href="#"><i class="fa fa-twitter"></i></a></li>' +
	'				<li><a href="#"><i class="fa fa-linkedin"></i></a></li>' +
	'				<li><a href="#"><i class="fa fa-tumblr"></i></a></li>' +
	'				<li><a href="#"><i class="fa fa-envelope-o"></i></a></li>' +
	'			</ul>' +
	'			<div class="post-meta pull-right">' +
	'				<span class="tg-post-author"><a href="#">View Comments</a></span>' +
	'			</div>' +
	'		</div>' +
	'	</div>' +
	'</article>';
	$( ".next-previous" ).before( article_content );
}