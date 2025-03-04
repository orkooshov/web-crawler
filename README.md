# Тестовое задание

Необходимо создать простой интернет crawler, который будет доставать из страниц информацию о названии сайта.
Это должно быть приложение с http эндпоинтом. На этот эндпоинт поступает список http url'ов. Приложение должно пройтись по всем предоставленным урлам и достать оттуда название.
Названием условно будем считать содержимое тэга title. После изъятия информации из всех страниц эндпоинт должен вернуть ответ, в котором каждому входному урлу соответствует найденное название.
Все недостающие требования или неоднозначности начальной формулировки задачи вы должны разрешить самостоятельно - это является частью задания.

Единственное требование к реализации - приложение должно быть написано на языке Scala.
