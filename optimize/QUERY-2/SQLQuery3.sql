SELECT * FROM GIAMGIA WHERE MA_TOUR LIKE '%S'

CREATE NONCLUSTERED INDEX [_dta_index_GG] ON [dbo].[GIAMGIA]
(
	[MA_TOUR] ASC
)WITH (SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF) ON [PRIMARY]