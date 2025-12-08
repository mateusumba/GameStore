package com.example.gamestore.data

import com.example.gamestore.model.Game
import com.example.gamestore.model.PurchasableItem
import com.example.gamestore.R

object SampleData {

    val games = listOf(
        Game(
            id = 1,
            name = "Cyberpunk 2077",
            description = "Um RPG de ação e aventura em mundo aberto em Night City, uma megalópole obcecada por poder, glamour e modificações corporais. joga como  um mercenário fora da lei atrás de um implante único que é a chave para a imortalidade.",
            imageResId = R.drawable.cyberpunk_bg,
            purchasableItems = listOf(
                PurchasableItem(
                    id = 101,
                    name = "Phantom Liberty",
                    description = "Expansão de espionagem com nova história, personagens e área para explorar.",
                    detailedDescription = "Phantom Liberty é uma expansão de espionagem para Cyberpunk 2077 que leva V a uma missão perigosa de infiltração e espionagem em uma nova área de Night City. Com nova história, personagens, missões e equipamentos.",
                    price = 12.99,
                    imageResId = R.drawable.cyberpunk2077_11
                ),
                PurchasableItem(
                    id = 102,
                    name = "Samurai Jacket Pack",
                    description = "Coleção de jaquetas estilizadas inspiradas na banda Samurai do jogo.",
                    detailedDescription = "Este pacote inclui 3 jaquetas exclusivas inspiradas na banda Samurai. Cada jaqueta tem designs únicos, cores vibrantes e efeitos especiais quando equipadas.",
                    price = 12.99,
                    imageResId = R.drawable.cyberpunk2077_2
                ),
                PurchasableItem(
                    id = 103,
                    name = "Weapon Skin Pack",
                    description = "Pacote de skins exclusivas para suas armas favoritas.",
                    detailedDescription = "Transforme suas armas com 10 skins exclusivas. Inclui designs cibernéticos, neon e tema corporativo para personalizar completamente seu arsenal.",
                    price = 12.99,
                    imageResId = R.drawable.cyberpunk2077_33
                )
            )
        ),
        Game(
            id = 2,
            name = "The Witcher 3",
            description = "Você é Geralt de Rívia, um caçador de monstros em um mundo de fantasia sombria. Explore um continente devastado pela guerra, complete missões perigosas e encontre a criança da profecia.",
            imageResId = R.drawable.witcher_bg,
            purchasableItems = listOf(
                PurchasableItem(
                    id = 201,
                    name = "Blood and Wine",
                    description = "Expansão que leva Geralt à região vinícola de Toussaint.",
                    detailedDescription = "Blood and Wine é uma expansão massiva que adiciona mais de 30 horas de conteúdo. Explore a nova região de Toussaint, complete novas missões, enfrente novos monstros e descubra segredos sombrios.",
                    price = 12.99,
                    imageResId = R.drawable.thewither_1
                ),
                PurchasableItem(
                    id = 202,
                    name = "Hearts of Stone",
                    description = "Expansão com uma história sombria sobre um misterioso homem imortal.",
                    detailedDescription = "Hearts of Stone traz uma história sombria e emocionante sobre um contrato com um homem imortal misterioso. Nova área, novos monstros, armaduras e armas para descobrir.",
                    price = 12.99,
                    imageResId = R.drawable.thewither_22
                ),
                PurchasableItem(
                    id = 203,
                    name = "Alternative Look Pack",
                    description = "Skins alternativas para personagens principais do jogo.",
                    detailedDescription = "Mude a aparência de Geralt, Yennefer, Triss e Ciri com essas skins alternativas. Cada skin vem com design único e detalhes especiais.",
                    price = 12.99,
                    imageResId = R.drawable.thewither_33
                )
            )
        ),

        Game(
            id = 3,
            name = "The Last of Us",
            description = "Uma jornada intensa de sobrevivência num mundo pós-apocalíptico dominado por infectados e humanos perigosos.",
            imageResId = R.drawable.thelastofus_bg,
            purchasableItems = listOf(
                PurchasableItem(
                    id = 301,
                    name = "Arco de Joel",
                    description = "Arma silenciosa ideal para furtividade.",
                    detailedDescription = "Arma silenciosa ideal para furtividade, permitindo eliminar inimigos de forma discreta e precisa sem chamar atenção. Essencial para situações em que a sobrevivência depende da cautela e da estratégia.",
                    price = 12.99,
                    imageResId = R.drawable.thelastofus_1
                ),
                PurchasableItem(
                    id = 302,
                    name = "Máscara de Gás",
                    description = "Protege contra esporos e ambientes tóxicos.",
                    detailedDescription = "Fornece proteção essencial contra esporos e ambientes tóxicos, garantindo a sobrevivência em áreas contaminadas e permitindo explorar locais perigosos com maior segurança.",
                    price = 12.99,
                    imageResId = R.drawable.thelastofus_2
                ),
                PurchasableItem(
                    id = 303,
                    name = "Kit Médico",
                    description = "Recupera saúde em situações críticas.",
                    detailedDescription = "Recupera saúde em situações críticas, permitindo ao jogador sobreviver a combates intensos e continuar a explorar mesmo após ferimentos graves. Um recurso indispensável em momentos de grande perigo.",
                    price = 12.99,
                    imageResId = R.drawable.thelastofus_3
                )
            )
        )

    )
}