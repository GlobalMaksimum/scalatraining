Verilen linkten https://grouplens.org/datasets/movielens/ movielens dataset dedigimiz dataset indirilerek data parse ediltikten sonra asagidaki sorulari cevapliycak olan kodlari yaziniz. 1M lik olan small dataset kullanilabilir.
Sorular cevaplanirken functional paradigmalara dikkat edilerek(while loop,vars kullanilmadan) cevaplanmasi istenmektedir. 

* Yıllara ve türlere (genre) göre film sayıları nedir? (1985 korku filmi x adet, aksiyon filmi y adet, 1986 korku filmi x’ adet, aksiyon filmi y’ adet gibi)
* Rating puanlarına göre en fazla yüksek puan verilen yıl hangisidir (sinemanın altın yılı 😊)
* Yıllara göre film adedi en düşük olan türlerin genel ortalamadaki yeri nedir?(yıllık film adedi en düşük olan 10 yılda toplam 13 filmle romantik komedi türüdür ve toplamda xyz adet film arasında abc adet çekilmiştir)
* Türlere göre Tag yapan kullanıcıların rating puanı verme ortalaması nedir ve bu oran hangi yılda peak yapmıştır?(komedi filmleri için tag veren her 10 kişiden 8’i filme puan da vermektedir ve bu oran 2018 yılında %90’la peak yapmıştır)
* En fazla tag veren kişinin en sevdiği ve en sevmediği türler hangi yıllardadır?  (519 adet tag’le en fazla tag yapan x id’li kullanıcının en yüksek  puan verdiği yıl 1985 yılı aksiyon filmleridir, en az puan verdiği yıl 2000 yılı romantik komedi filmleridir)
* Türlerine göre filmlere önce tag yapılıp sonra mı puan verilmektedir yoksa önce puan verilip sonra mı tag yapılmaktadır?(burada ilk event tag mi yoksa puan mı bakılsa yeterli zira tag-puan-tag şeklinde de gidebilir.) 

BONUS: Yukaridaki soru cevaplanirken kullanilabilecek olan datatypelardan bir tanesi Listdir. Yukaridaki sorulari List classini immutable bir sekilde tekrar implement ederek cevaplayabilirsiniz.   